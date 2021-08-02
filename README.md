# Fetch Rewards Project
Candidate: Noah Fields

## Running
To run:
Enter the following into the command line:
`java -jar ferchrewards.jar`

## Endpoints

### /add
use payload (e.g.):
`{ "payer": "DANNON", "points": 300, "timestamp": "2020-10-31T10:00:00Z" }`
returns 200 status code

### /get
returns list of payers with amounts in form: 
`{"DANNON": 50, "UNILEVER": 1000}`

### /deduct
use payload (e.g.):
`50` (e.g. `curl localhost:8080\deduct -d 50`)

returns list of itemized deductions, e.g.
`{"Dannon": -50, "Unilever": -100}`


## Notes

Due to time constraints, I left out some edge cases and some error handling.