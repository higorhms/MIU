# Activity and Benefit API Usage Guide

This is a guide to using the Activity and Benefit APIs, built using Node.js and Mongoose.

Please, note that there is a file called http-client-requests.json exporting all the requests suported that you can easily import to your http client and save some time.

## Prerequisites

You will need the following installed:
- Node.js
- MongoDB
- npm

The `.env` contain the environment specific constants such as:
- `ACTIVITY_MODEL`: Name of the mongoose model representing your activity schema.
- `BENEFIT_MODEL`: Name of the mongoose model representing your benefit schema.
- `BENEFITS_COLLECTION`: Name of the field representing the benefits collection.
- `INVALID_PAGINATION_MESSAGE`: Error message for invalid pagination.
- `INVALID_COUNT_MESSAGE`: Error message for invalid count.
- `ACTIVITY_NOT_FOUND_MESSAGE`: Error message for when an activity is not found.
- `BENEFIT_NOT_FOUND_MESSAGE`: Error message for when a benefit is not found.

## Installation and Setup

1. Navigate to the root directory of your project.
2. Install the necessary dependencies by running `npm install`.
3. Start your MongoDB instance.

### Find All Activities
- Method: `GET`
- Route: `/activities`
- Query Parameters: 
  - `offset`: (optional) The number of documents to skip before starting to return results.
  - `count`: (optional) The number of documents to return.

### Find Activity by ID
- Method: `GET`
- Route: `/activities/:activityId`

### Insert a New Activity
- Method: `POST`
- Route: `/activities`
- Body: JSON object representing the new activity.

### Delete an Activity
- Method: `DELETE`
- Route: `/activities/:activityId`

### Partially Update an Activity
- Method: `PATCH`
- Route: `/activities/:activityId`
- Body: JSON object representing the fields to be updated.

### Replace an Activity
- Method: `PUT`
- Route: `/activities/:activityId`
- Body: JSON object representing the new activity.

### Find All Benefits of an Activity
- Method: `GET`
- Route: `/activities/:activityId/benefits`

### Find a Benefit by ID
- Method: `GET`
- Route: `/activities/:activityId/benefits/:benefitId`

### Insert a New Benefit to an Activity
- Method: `POST`
- Route: `/activities/:activityId/benefits`
- Body: JSON object representing the new benefit.

### Delete a Benefit from an Activity
- Method: `DELETE`
- Route: `/activities/:activityId/benefits/:benefitId`

### Partially Update a Benefit of an Activity
- Method: `PATCH`
- Route: `/activities/:activityId/benefits/:benefitId`
- Body: JSON object representing the fields to be updated.

### Replace a Benefit of an Activity
- Method: `PUT`
- Route: `/activities/:activityId/benefits/:benefitId`
- Body: JSON object representing the new benefit.

Please replace `:activityId` with the actual `ObjectId` of the Activity and `:benefitId` with the `ObjectId` of the Benefit you want to interact with.

## Error Handling

In case of errors, the API will respond with appropriate HTTP status codes and JSON objects containing a message detailing the error.
