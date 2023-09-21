public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        int[] ransomfreq = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            ransomfreq[magazine.charAt(i) - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (ransomfreq[c - 'a'] == 0) {
                return false;
            }
            ransomfreq[c - 'a']--;
        }
        return true;
    }
}
