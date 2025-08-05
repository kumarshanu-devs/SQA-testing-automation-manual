# API Testing Report

## Objective
To test basic CRUD operations using Postman on the JSONPlaceholder mock API.

## Test Summary
| Method | Endpoint                  | Status | Notes                     |
|--------|---------------------------|--------|---------------------------|
| GET    | /posts                    | 200 OK | Retrieved all posts       |
| GET    | /posts/1                  | 200 OK | Retrieved post ID 1       |
| POST   | /posts                    | 201 Created | Created new post     |
| PUT    | /posts/1                  | 200 OK | Updated post ID 1         |
| DELETE | /posts/1                  | 200 OK | Deleted post ID 1         |

## Conclusion
All CRUD operations executed successfully. JSON responses validated for expected keys and structure.