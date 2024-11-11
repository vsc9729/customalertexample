# CustomAlertDialog Component

A customizable alert dialog component built with Jetpack Compose for Android applications. This component provides a modern, Material Design 3 compliant dialog with flexible styling and callback options.

## Features

- Material Design 3 styling
- Customizable title and message
- Configurable confirm and cancel buttons
- Rounded corners and proper spacing
- Responsive layout with proper alignment
- Built-in dismiss functionality

## Usage

```kotlin
CustomAlertDialog(
    showDialog = true,
    onDismissRequest = { buttonText -> /* Handle dismiss */ },
    title = "Confirm Action",
    message = "Are you sure you want to proceed?",
    confirmButtonText = "Yes",
    cancelButtonText = "No",
    onConfirmClick = { /* Handle confirmation */ },
    onCancelClick = { /* Handle cancellation */ }
)
```

## Parameters

![Params Table]([http://url/to/img.png](https://github.com/vsc9729/customalertexample/blob/main/images/table.png))

## Styling

The dialog uses the following styling properties:
- Card shape: Rounded corners (16.dp)
- Title text: 20.sp with bold font weight
- Message text: 16.sp with regular font weight
- Padding: 16.dp for both outer and inner content
- Button colors:
  - Confirm button: Uses the primary color from MaterialTheme
  - Cancel button: Uses gray color

## Layout Structure

The component follows this hierarchy:
```
Dialog
└── Card
    └── Column
        ├── Title Text
        ├── Spacer (16.dp)
        ├── Message Text
        ├── Spacer (24.dp)
        └── Row
            ├── Cancel Button
            └── Confirm Button
```

## Dependencies

This component requires the following Jetpack Compose dependencies:
```gradle
implementation "androidx.compose.material3:material3"
implementation "androidx.compose.foundation:foundation"
implementation "androidx.compose.ui:ui"
```

## Notes

- The dialog automatically dismisses when clicking outside the dialog area
- Both buttons will trigger the onDismissRequest callback with their respective button text
- The component uses Material Design 3 theming by default
