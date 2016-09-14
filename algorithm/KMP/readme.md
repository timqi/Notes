[Knuth–Morris–Pratt algorithm](https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm)

[字符串匹配的KMP算法](http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)

伪代码：

    algorithm kmp_search:
        input:
            an array of characters, S (the text to be searched)
            an array of characters, W (the word sought)
        output:
            an integer (the zero-based position in S at which W is found)

        define variables:
            an integer, m ← 0 (the beginning of the current match in S)
            an integer, i ← 0 (the position of the current character in W)
            an array of integers, T (the table, computed elsewhere)

        while m + i < length(S) do
            if W[i] = S[m + i] then
                if i = length(W) - 1 then
                    return m
                let i ← i + 1
            else
                if T[i] > -1 then
                    let m ← m + i - T[i], i ← T[i]
                else
                    let m ← m + 1, i ← 0

        (if we reach here, we have searched all of S unsuccessfully)
        return the length of S

部分匹配表：

    algorithm kmp_table:
        input:
            an array of characters, W (the word to be analyzed)
            an array of integers, T (the table to be filled)
        output:
            nothing (but during operation, it populates the table)

        define variables:
            an integer, pos ← 2 (the current position we are computing in T)
            an integer, cnd ← 0 (the zero-based index in W of the next character of the current candidate substring)

        (the first few values are fixed but different from what the algorithm might suggest)
        let T[0] ← -1, T[1] ← 0

        while pos < length(W) do
            (first case: the substring continues)
            if W[pos-1] = W[cnd] then
                let T[pos] ← cnd + 1, cnd ← cnd + 1, pos ← pos + 1

            (second case: it doesn't, but we can fall back)
            else if cnd > 0 then
                let cnd ← T[cnd]

            (third case: we have run out of candidates.  Note cnd = 0)
            else
                let T[pos] ← 0, pos ← pos + 1
