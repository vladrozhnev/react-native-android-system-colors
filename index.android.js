/** @format */

import { NativeModules } from 'react-native';

export const AndroidSystemColors = {
  setNavigationBarColor(color, duration) {
    try {
      if (/^#([0-9A-F]{3}){1,2}$/i.test(color)) {
        const time = duration ? Math.max(Math.trunc(duration), 0) || 0 : 0;
        NativeModules.ReactNativeAndroidSystemColors.setNavigationBarColor(color, time);
      } else {
        if (__DEV__) {
          const method = '[AndroidSystemColors.setNavigationBarColor]';
          const message = 'Incorrect color type. The color must be provided as a string in hex format.';

          console.warn(`${method}: ${message}`);
        }
      }
    } catch (error) {
      const method = '[AndroidSystemColors.setNavigationBarColor]';
      console.error(`${method}: ${error.message}`);
    }
  },

  setStatusBarColor(color, duration) {
    try {
      if (/^#([0-9A-F]{3}){1,2}$/i.test(color)) {
        const time = duration ? Math.max(Math.trunc(duration), 0) || 0 : 0;
        NativeModules.ReactNativeAndroidSystemColors.setStatusBarColor(color, time);
      } else {
        if (__DEV__) {
          const method = '[AndroidSystemColors.setStatusBarColor]';
          const message = 'Incorrect color type. The color must be provided as a string in hex format.';

          console.warn(`${method}: ${message}`);
        }
      }
    } catch (error) {
      const method = '[AndroidSystemColors.setStatusBarColor]';
      console.error(`${method}: ${error.message}`);
    }
  },

  setTaskDescriptionColor(color) {
    try {
      if (/^#([0-9A-F]{3}){1,2}$/i.test(color)) {
        NativeModules.ReactNativeAndroidSystemColors.setTaskDescriptionColor(color);
      } else {
        if (__DEV__) {
          const method = '[AndroidSystemColors.setTaskDescriptionColor]';
          const message = 'Incorrect color type. The color must be provided as a string in hex format.';

          console.warn(`${method}: ${message}`);
        }
      }
    } catch (error) {
      const method = '[AndroidSystemColors.setTaskDescriptionColor]';
      console.error(`${method}: ${error.message}`);
    }
  },
};
