# Bug ID: Login-001

## Summary
Login page shows generic error message even for empty username field.

## Steps to Reproduce
1. Go to login page.
2. Leave username blank.
3. Enter any password.
4. Click Login.

## Expected Result
Validation error message should prompt "Username is required."

## Actual Result
Generic error message "Invalid username or password." is shown.

## Severity
Medium
