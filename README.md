# AWS User Deletion Procedure

## Purpose:
This document provides step-by-step instructions for deleting a user from the AWS account to revoke their access to resources.

## Pre-requisites:
1. AWS root account credentials.
2. Knowledge of AWS Identity and Access Management (IAM).

## Steps to Delete a User:

### 1. Log in to the AWS Management Console:
   - Open a web browser and navigate to the AWS Management Console (https://aws.amazon.com/).
   - Log in using the root account credentials.

### 2. Access IAM (Identity and Access Management):
   - In the AWS Management Console, navigate to the IAM dashboard.

### 3. Locate the User:
   - Click on "Users" in the left navigation pane.
   - Find and select the user account you want to delete.

### 4. Delete User:
   - **Warning: Deleting a user is irreversible. Ensure this is necessary.**
   - Select the user you want to delete.
   - In the "User actions" menu, choose "Delete user."
   - Follow the prompts to confirm the deletion.

### 5. Confirm Deletion:
   - Double-check the user details to ensure you are deleting the correct user account.
   - Confirm the deletion by entering the user's username when prompted.

### 6. Review Permissions:
   - Ensure that the user no longer has any direct or group permissions that grant access to AWS resources.

### 7. Review IAM Roles:
   - Check if the user was assuming any IAM roles. Adjust or remove these roles as necessary.

### 8. Review CloudTrail and AWS Config (If Applicable):
   - Check AWS CloudTrail and AWS Config to ensure there are no lingering traces of the user's activity.

### 9. Monitor for Changes:
   - Regularly monitor AWS CloudTrail logs and IAM events to ensure the deleted user does not attempt unauthorized access.

## Conclusion:
This document outlines the steps to delete a user from the AWS account. Please follow these steps carefully to maintain the security and integrity of AWS resources.

