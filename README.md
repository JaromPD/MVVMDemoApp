# MVVM SpedTalk App

This is a simple demo application demonstrating the Model-View-ViewModel (MVVM) architecture pattern in Android development. The app allows users to view and edit their name, major, and age, and it saves these changes to a Firebase database.

## Video Explanation

For a quick explanation of MVVM, you can watch the YouTube video [here]([https://youtu.be/a3d6t10IlDk](https://youtu.be/7S6pLsleypk)).

## Project Structure

The project follows the MVVM architecture and is structured into three main directories:

- `Models`: This directory contains the data classes and Firebase helper class. The data classes define the structure of the data used in the app, and the Firebase helper class contains the logic for interacting with the Firebase database. The file path for this directory is `app/src/main/java/com/example/mvvmspedtalk/Models`.

- `Views`: This directory contains the UI components of the app, which are built using Jetpack Compose. The main UI components are defined in the `AppContent.kt` file, which is located at `app/src/main/java/com/example/mvvmspedtalk/Views/AppContent.kt`.

- `ViewModels`: This directory contains the ViewModel classes, which handle the business logic of the app and provide data for the UI components. The file path for this directory is `app/src/main/java/com/example/mvvmspedtalk/ViewModels`.

## Setup

To run this project, you will need to have Android Studio installed. You can then clone this repository and open the project in Android Studio. From there, you can run the app on an emulator or a connected Android device.

## Technologies Used

- Kotlin: The main programming language used in this project.
- Jetpack Compose: A modern toolkit for building native Android UI.
- Firebase: A platform from Google for developing web and mobile apps. It is used in this project for data storage.

## Contributing

Contributions are welcome!
