# expand-year [![Build Status](https://travis-ci.org/bendrucker/expand-year.svg?branch=master)](https://travis-ci.org/bendrucker/expand-year)

> Expand a short year to a full year (`15` -> `2015`)


## Install

```
$ npm install --save expand-year
```


## Usage

```js
var expandYear = require('expand-year');

expandYear(15) // 2015
```

## API

#### `expandYear(year, [now])` -> `number`

##### year

*Required*  
Type: `number`

The year to expand. A one or two digit number is expected.

##### now

Type: `date`  
Default: `new Date()`

The date object from which to calculate the current year.


## License

MIT © [Ben Drucker](http://bendrucker.me)
