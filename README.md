# person-api

A `Person` has a `House` and can have multiple Children. Every `Child` has favorite `Meals` which are sorted (first is the one it likes most).

Now, this Spring application which provides two endpoints:

- `/house` This endpoint returns the `House` for a given person
- `/child/info` This endpoint returns the `Parent` and the most favorite `meal` of a `child`

The frontend that will use these endpoints will perform ~100,000 requests per hour and 70% of those will be `/house` and 30% will be `/child/info`. All responses have to be in JSON format. 

An additional endpoint `/color` that returns, for a given `Child`, the `hairColor` if the `Child` is a Daughter or the `bicycleColor` if the `Child` is a Son.

Imagining that there are around 100,000,000 Persons and 300,000,000 Children in the database and there is a new endpoint `/persons/children` which returns an array in which the element `n` is the amount of
people having `n` children. To speed up this request, there's a job which runs every 15 minutes, calculates those numbers and puts them into a new entity `ParentSummary`. 