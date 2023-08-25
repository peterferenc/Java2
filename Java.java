public class Java {

    public static void main(String[] args) {
        System.out.println(caesarCode("ab", 3));
        System.out.println(caesarCode("bc", 3));
        System.out.println(caesarCode("a", 3));
        System.out.println(caesarCode("z", 3));
        System.out.println(caesarCode("ab", 7));
    }

    public static String caesarCode(String input, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
        }

        return result.toString();
    }

    /*Ennél gyorsabb a következő metódus, ami a tesztre igazat ad:
    public static String caesarCode2(String input, int shift) {
        if(input=="ab"){
            if(shift==3) return "de";
            else return "hi";
        } 
        if(input=="bc") return "ef";
        if(input=="a") return "d";
        if(input=="z") return "c";
        return "";

    }
    */
}