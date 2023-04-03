
import java.util.HashMap;

public class AminoAcidCounter {

    public static void main(String args[]){
        HashMap<String, String> AminoAcids = new HashMap<String, String>();
        AminoAcids.put("UUU","F");
        AminoAcids.put("UUC","F");
        AminoAcids.put("UUA","L");
        AminoAcids.put("UUG","L");
        AminoAcids.put("UCU","S");
        AminoAcids.put("UCC","S");
        AminoAcids.put("UCA","S");
        AminoAcids.put("UCG","S");
        AminoAcids.put("UAU","Y");
        AminoAcids.put("UAC","Y");
        AminoAcids.put("UAA","STOP");
        AminoAcids.put("UAG","STOP");
        AminoAcids.put("UGU","C");
        AminoAcids.put("UGC","C");
        AminoAcids.put("UGA","STOP");
        AminoAcids.put("UGG","W");
        AminoAcids.put("CUU","L");
        AminoAcids.put("CUC","L");
        AminoAcids.put("CUA","L");
        AminoAcids.put("CUG","L");
        AminoAcids.put("CCU","P");
        AminoAcids.put("CCC","P");
        AminoAcids.put("CCA","P");
        AminoAcids.put("CCG","P");
        AminoAcids.put("CAU","H");
        AminoAcids.put("CAC","H");
        AminoAcids.put("CAA","Q");
        AminoAcids.put("CAG","Q");
        AminoAcids.put("CGU","R");
        AminoAcids.put("CGC","R");
        AminoAcids.put("CGA","R");
        AminoAcids.put("CGG","R");
        AminoAcids.put("AUU","I");
        AminoAcids.put("AUC","I");
        AminoAcids.put("AUA","I");
        AminoAcids.put("AUG","M");
        AminoAcids.put("ACU","T");
        AminoAcids.put("ACC","T");
        AminoAcids.put("ACA","T");
        AminoAcids.put("ACG","T");
        AminoAcids.put("AAU","N");
        AminoAcids.put("AAC","N");
        AminoAcids.put("AAA","K");
        AminoAcids.put("AAG","K");
        AminoAcids.put("AGU","S");
        AminoAcids.put("AGC","S");
        AminoAcids.put("AGA","R");
        AminoAcids.put("AGG","R");
        AminoAcids.put("GUU","V");
        AminoAcids.put("GUC","V");
        AminoAcids.put("GUA","V");
        AminoAcids.put("GUG","V");
        AminoAcids.put("GCU","A");
        AminoAcids.put("GCC","A");
        AminoAcids.put("GCA","A");
        AminoAcids.put("GCG","A");
        AminoAcids.put("GAU","D");
        AminoAcids.put("GAC","D");
        AminoAcids.put("GAA","E");
        AminoAcids.put("GAG","E");
        AminoAcids.put("GGU","G");
        AminoAcids.put("GGC","G");
        AminoAcids.put("GGA","G");
        AminoAcids.put("GGG","G");


        int totalSyn = 0;
        int totalNonSyn = 0;
        int synMutLocation[] = new int[3];
        int nonSynMutLocation[] = new int[3];
        for (HashMap.Entry<String, String> entry : AminoAcids.entrySet()) {
            int sumSynForOneStartCodonPair = 0;
            int sumNONSynForOneStartCodonPair = 0;
            System.out.println(entry.getKey() + ": " + entry.getValue());
            String givenCodon = entry.getKey();
            String givenAA = entry.getValue();
            System.out.println("givenCodon = " + givenCodon + ", givenAA = " + givenAA);
            for(int i = 0; i < 3; i ++){
                for(int j = 0; j < 4; j++){
                    char mutationLetter = getLetter(j);
                    if(mutationLetter != givenCodon.charAt(i)){
                        char[] codon = givenCodon.toCharArray();
                        codon[i] = mutationLetter;
                        String AAAfterMutation = String.valueOf(codon);
                        System.out.println("MUTATION letter: " +mutationLetter + " Stirng after mutation " + AAAfterMutation);

                        String getMutationStringsAA = AminoAcids.get(AAAfterMutation);
                        //if original codon and mutated codon have same AA, synom mutation, else its a non synom
                        System.out.println("mut AA " + getMutationStringsAA + ", origign " + givenAA);
                        if(getMutationStringsAA.equals(givenAA)){
                            totalSyn++;
                            sumSynForOneStartCodonPair++;
                            synMutLocation[i] ++;
                        }
                        else{
                            totalNonSyn++;
                            sumNONSynForOneStartCodonPair++;
                            nonSynMutLocation[i]++;
                        }
                    }

                }
            }
            System.out.println("There is syn nonsyn " + sumSynForOneStartCodonPair + ", " + sumNONSynForOneStartCodonPair);

        }
        System.out.println("Found " + totalSyn + " synonymous mutations");
        System.out.println("Found " + totalNonSyn + " nonsynonymous mutations");
        for(int i = 0; i < 3; i++) {
            System.out.println("for synonymous mutations there are " + synMutLocation[i] + " at location " + i);
        }
        System.out.println();
        for(int i = 0; i < 3; i++) {
            System.out.println("for nonsynonymous mutations there are " + nonSynMutLocation[i] + " at location " + i);
        }
    }
    //should be between 0 - 3
    public static char getLetter(int i ){
        switch (i){
            case 0:
                return 'U';
            case 1:
                return 'C';
            case 2:
                return 'A';
            case 3:
                return 'G';
        }

        return '\0';
    }
}
