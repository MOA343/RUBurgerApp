# RUBurgerApp 🍔

RUBurgerApp is a fully-featured Android app developed in Kotlin for creating custom burger orders with intuitive user interfaces, dynamic pricing, and full order management. Designed for an engaging user experience, it supports multiple food categories such as burgers, sandwiches, sides, and beverages.

## 📱 Features

- 🧾 **Dynamic Price Updates**: Prices automatically adjust based on user selections.
- 🍔 **Customizable Burgers & Sandwiches**: Choose bread, protein, and add-ons.
- 🧃 **Drinks and Sides**: Select quantity and type from drop-down spinners.
- 📦 **Order Review & Management**:
  - View complete order details
  - Cancel items or clear the entire order
  - Complete and finalize order
- 💾 **Order Export**: Save your complete order summary to a local file.
- ✅ **UI Components Used**:
  - `RecyclerView`
  - `Toast`
  - `AlertDialog`
  - `Spinner`
  - `ListView`
  - `ImageView`

## 📂 Project Structure

```bash
RUBurgerApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/ruburger/
│   │   │   │   ├── model/                # Data models (Burger, Sandwich, etc.)
│   │   │   │   ├── adapter/              # RecyclerView Adapters
│   │   │   │   ├── *.kt                  # Activities
│   │   │   ├── res/
│   │   │   │   ├── layout/               # XML Layouts
│   │   │   │   ├── drawable/             # App icons and images
│   │   │   │   ├── values/               # Strings, arrays, colors, themes
│   │   │   │   └── xml/                  # Backup & data extraction
│   ├── build.gradle.kts
├── build.gradle.kts
└── libs.versions.toml

🧪 Testing

Unit tests are written with JUnit under:

app/src/test/java/com/example/ruburger/


Use Android Studio’s test runner to verify:

Pricing logic

Order management (add/remove/clear)

Item creation validation

🧰 Tech Stack

Language: Kotlin

UI Toolkit: Android XML layouts (not Jetpack Compose)

Frameworks: AndroidX, Material Components

Build Tool: Gradle Kotlin DSL

Testing: JUnit

📸 Screenshots

(Add screenshots of your app screens here, such as main menu, burger builder, and order details)

📦 APK

To build and install the APK:

./gradlew assembleDebug
adb install app/build/outputs/apk/debug/app-debug.apk

🧑‍💻 Authors

Muhammad Abbasi - @MOA343

Aaman Gafur

📄 License

This project is for academic purposes under Rutgers University CS214 Project 5.
