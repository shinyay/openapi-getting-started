# Getting Started with OpenAPI Generator

Overview

## Description
### Dependency
- `de.qaware.tools.openapi-generator-for-spring`
  - `openapi-generator-for-spring-starter:1.0.1`

## Demo
### H2 Database Console
- [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
![image](https://user-images.githubusercontent.com/3072734/107363278-41608400-6b1d-11eb-99d9-c280bf512f6f.png)

### OpenAPI Document
```shell script
$ gradle bootRun
```
Access `swagger-ui`
- [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

### Deploy to Cloud Run
```shell script
$ gcloud beta run deploy --memory 512Mi --source .
```

#### Access to Service on Cloud Run
```shell script
$ curl -H "Authorization: Bearer "(gcloud auth print-identity-token)"" (gcloud run services list --format json |jq -r .[0].status.url)/api/v1/employees
```

### API Gateway
#### Service Account
```shell script
$ gcloud iam service-accounts create spring-app --display-name "Spring App"
$ gcloud iam service-accounts list
$ gcloud projects add-iam-policy-binding (gcloud config get-value project) \                                                                                                   4458ms  2021-02-12 15:26
    --member serviceAccount:spring-app@(gcloud config get-value project).iam.gserviceaccount.com \
    --role roles/iam.serviceAccountUser
```

#### Enable Services
We enable the following Google services:

|Name|Title|
|----|-----|
|apigateway.googleapis.com|API Gateway API|
|servicemanagement.googleapis.com|Service Management API|
|servicecontrol.googleapis.com|Service Control API|

```shell script
$ gcloud services enable apigateway.googleapis.com
$ gcloud services enable servicemanagement.googleapis.com
$ gcloud services enable servicecontrol.googleapis.com
```

#### Create API Config
```shell script
$ gcloud api-gateway api-configs create employee-app-config \
    --api employee-app \
    --openapi-spec openapi.yml \
    --project (gcloud config get-value project) \
    --backend-auth-service-account spring-app@(gcloud config get-value project).iam.gserviceaccount.com
```


## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References
- [OpenAPI v3 generator for Spring Boot](https://github.com/qaware/openapi-generator-for-spring)
- [JSON to YAML](https://www.json2yaml.com/)
- [APIMATIC](https://www.apimatic.io/dashboard)
## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
