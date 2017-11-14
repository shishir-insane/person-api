package com.sk.wagawin.person.controller;

import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.context.request.async.DeferredResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProcessingTask extends TimerTask {

    private final long reqId;
    private final AtomicLong concurrentRequests;
    private final DeferredResult<ProcessingStatus> deferredResult;
    private final int processingTimeMs;

    public ProcessingTask(final long reqId, final AtomicLong concurrentRequests, final int processingTimeMs,
            final DeferredResult<ProcessingStatus> deferredResult) {
        this.reqId = reqId;
        this.concurrentRequests = concurrentRequests;
        this.processingTimeMs = processingTimeMs;
        this.deferredResult = deferredResult;
    }

    @Override
    public void run() {
        final long concReqs = concurrentRequests.getAndDecrement();
        if (deferredResult.isSetOrExpired()) {
            log.warn("{}: Processing of non-blocking request #{} already expired", concReqs, reqId);
        } else {
            final boolean deferredStatus = deferredResult.setResult(new ProcessingStatus("Ok", processingTimeMs));
            log.debug("{}: Processing of non-blocking request #{} done, deferredStatus = {}", concReqs, reqId,
                    deferredStatus);
        }
    }
}