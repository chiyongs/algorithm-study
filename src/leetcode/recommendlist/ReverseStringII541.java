
    public String reverseStr(String s, int k) {
        int n = s.length();
        int startIndex = 0;
        int chunkSize = 2 * k;
        int endIndex = chunkSize;
        String temp = "", result = "";

        if (n <= k) {
            return reverseSubstring(s, k);
        }

        for (int i = 0; i < n; i++) {
            if (startIndex < n) {
                if (endIndex < n) {
                    temp = s.substring(startIndex, endIndex);
                    result += reverseSubstring(temp, k);
                } else {
                    temp = s.substring(startIndex, n);
                    result += reverseSubstring(temp, k);
                    break;
                }
                if (endIndex == n) break;
            }
            startIndex += chunkSize;
            endIndex += chunkSize;
        }
        return result;
    }

    static String reverseSubstring(String str, int k) {
        if (str.length() == 1) {
            return str;
        }
        if (str.length() <= k) {
            return new StringBuilder(str).reverse().toString();
        }
        String reversedPart = new StringBuilder(str.substring(0, k)).reverse().toString();
        String remainingPart = str.substring(k);
        return reversedPart + remainingPart;
    }
