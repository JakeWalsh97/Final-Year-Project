# is-valid-month [![Build Status](https://travis-ci.org/bendrucker/is-valid-month.svg?branch=master)](https://travis-ci.org/bendrucker/is-valid-month)

> Check if a number is a valid month


## Install

```
$ npm install --save is-valid-month
```


## Usage

```js
var isValidMonth = require('is-valid-month');

isValidMonth(1) // true
isValidMonth('1') // false
```

## API

#### `isValidMonth(month)` -> `boolean`

##### month

*Required*  
Type: `number`

The month is only valid if it is an integer between 1 and 12. Any other values are invalid, including strings and floats.

## License

MIT © [Ben Drucker](http://bendrucker.m/,e)
