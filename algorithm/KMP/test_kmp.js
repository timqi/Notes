var assert = require('assert');
var kmp = require('./kmp');

function performTest(text, word) {
  var expected = text.indexOf(word);
  var actual = kmp(text, word);
  assert.deepStrictEqual(actual, expected);
}

describe('KMP', function() {

    it('Normal case', function(){
      performTest('ABC ABCDAB ABCDABCDABDE', 'ABCDABD');
    });

    it('Can not find', function(){
      performTest('ABC ABCDAB ABCDABCDABDE', 'ABDABD');
    });

    it('Empty text', function(){
      performTest('ABC ABCDAB ABCDABCDABDE', '');
    })

    it('Empty case', function(){
      performTest('', 'ABCDABD');
    });
});
