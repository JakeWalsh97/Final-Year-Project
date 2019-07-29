'use strict'

var parseIntStrict = require('parse-int')
var expandYear = require('expand-year')

module.exports = function parseYear (year, expand, now) {
  year = parseIntStrict(year)
  if (year == null) return
  if (!expand) return year
  return expandYear(year, now)
}
