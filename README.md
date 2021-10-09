# react-native-android-system-colors

##### Library for managing the native colors of an Android app.

[![npm version](https://img.shields.io/npm/v/react-native-android-system-colors.svg?style=flat-square)](https://www.npmjs.com/package/react-native-android-system-colors)
[![npm downloads](https://img.shields.io/npm/dw/react-native-android-system-colors.svg?style=flat-square)](https://www.npmjs.com/package/react-native-android-system-colors)
[![npm license](https://img.shields.io/npm/l/react-native-android-system-colors.svg?style=flat-square)](https://www.npmjs.com/package/react-native-android-system-colors)

---

# Instalation

##### To install `react-native-android-system-colors` - you can use `npm` or `yarn` package manager.

```bash
npm install react-native-android-system-colors --save
```

or

```bash
yarn add react-native-android-system-colors
```

---

# Documentation

The `react-native-android-system-colors` library includes the `AndroidSystemColors` object interface that has the next methods: `setStatusBarColor`, `setNavigationBarColor`, `setTaskDescriptionColor`. Below you can find the documentation for all methods.

###### `Important! All colors should be provided in the hex format.`

---

## The `setNavigationBarColor` method

##### Method that change the navigation bar color.

##### The `setNavigationBarColor` method accept next arguments:

| Name          | Type    | Default value | Required |
| ------------- | ------- | ------------- | -------- |
| color (hex)   | string  |               | Yes      |
| duration (ms) | number  | 0             | No       |

---

## The `setStatusBarColor` method

##### Method that change the status bar color.

##### The `setStatusBarColor` method accept next arguments:

| Name          | Type    | Default value | Required |
| ------------- | ------- | ------------- | -------- |
| color (hex)   | string  |               | Yes      |
| duration (ms) | number  | 0             | No       |

---

## The `setTaskDescriptionColor` method

##### Method that change the recent color.

##### The `setTaskDescriptionColor` method accept next arguments:

| Name          | Type    | Default value | Required |
| ------------- | ------- | ------------- | -------- |
| color (hex)   | string  |               | Yes      |

---

# Examples

```js
  import React, { useEffect } from 'react';
  import { AndroidSystemColors } from 'react-native-android-system-colors';


  const App = () => {

    useEffect(() => {
      const animationDuration = 300;
      const hexColorString = '#2196F3';

      AndroidSystemColors.setStatusBarColor(hexColorString, animationDuration);
      AndroidSystemColors.setNavigationBarColor(hexColorString, animationDuration);
      AndroidSystemColors.setTaskDescriptionColor(hexColorString);
    }, []);

    return null;
  }
```

---