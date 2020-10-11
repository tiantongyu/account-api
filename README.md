#Account API
A demo springboot project providing two restful APIs for retrieve accounts data

## APIs

### /v1/accounts
this api returns all accounts

### /v1/account/{account_id}/transactions
this api returns all transactions for account with account_id

## How to run
```
gradle bootRun
```

## Notes
* H2 in memory db is used for this demo project
* Liquibase is used for bootstrapping test data
* MyBatis is used for ORM