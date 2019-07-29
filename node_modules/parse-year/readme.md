# parse-year [![Build Status](https://travis-ci.org/bendrucker/parse-year.svg?branch=master)](https://travis-ci.org/bendrucker/parse-year)

> Parse a year into its full number value


## Install

```
$ npm install --save parse-year
```


## Usage

```js
var parseYear = require('parse-year');

parseYear('2015') // 2015
parseYear('15', true) // 2015
```

## API

### `parseYear(year, [expand], [now])` -> `number` / `undefined`

Parses the year, returning `undefined` if the input was invalid.

##### year

*Required*  
Type: `string` / `number`

The year input to parse.

##### expand

Type: `boolean`  
Default: `false`

If `true`, expand the year from a 1 or 2 digit number into a full year number, e.g. `'15'` to `2015`.

##### now

Type: `date`  
Default: `new Date()`

The date from which to calculate the full year. Only used when `expand` is `true`.

## License

MIT © [Ben Drucker](http://bendrucker.me)
