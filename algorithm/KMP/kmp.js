function compileSelfTable(word) {
  var wordLength = word.length;
  if (wordLength == 1) {

  }
  var table = new Array();
  table[0] = -1;
  table[1] = 0;

  var c = 2, loopCount = 0;
  while (c < wordLength) {
    if (word[c - 1] ==  word[loopCount]) {
      loopCount++;
      table[c] = loopCount;
      c++;
    } else if (loopCount > 0) {
      loopCount = table[loopCount];
    } else {
      table[c] = 0;
      c++;
      loopCount = 0;
    }
  }
  return table;
}

module.exports = function(text, word) {
  var textLength = text.length;
  var wordLength = word.length;

  if (wordLength == 0) return 0;
  if (wordLength > text.length || text.length == 0) return -1;

  var table = compileSelfTable(word);

  var tc = 0, wc = 0;
  while(tc + wc < textLength) {
    if (text[tc + wc] == word[wc]) {
      if (wc == wordLength-1) {
        return tc;
      } else {
        wc++;
      }
    } else {
      if (table[wc] != -1) {
        tc = tc + wc - table[wc];
        wc = table[wc];
      } else {
        tc++;
        wc = 0;
      }
    }
  }
  return -1;
}
