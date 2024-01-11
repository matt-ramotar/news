# Scoop

## Getting Started

To get the app running on your local machine, follow these instructions.

## Prerequisites

- IntelliJ / Android Studio
- XCode
- A Google account

## Setting up Firebase

This project uses Firebase. To connect the app to Firebase, you need to use your own `google-services.json`. Follow
these steps to set it up:

1. Create a Firebase Project:
    - Go to the Firebase Console.
    - Click on "Add project" and follow the on-screen instructions to create a new Firebase project.
2. Register Your App with Firebase:
    - Inside the Firebase project you just created, click on "Add app" and select the appropriate platform (iOS or
      Android).
    - Follow the instructions to register your app. You'll need your app's package name (for Android) or bundle ID (for
      iOS).
3. Download `google-services.json`:
    - Once your app is registered, you will be prompted to download the `google-services.json` file.
    - Click on the download button and save the file.
4. Rename and move `google-services.json`:
    - Rename the downloaded file to `google-services.json` if it's not already named that.
    - Move this file to the root of the /app directory.
