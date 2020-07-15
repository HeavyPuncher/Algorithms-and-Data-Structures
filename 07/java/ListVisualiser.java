public class ListVisualiser {
    SLList mySLList;
//mySLList is declared publicly

    int val;

    public ListVisualiser(SLList l) {

        this.mySLList = l;
    }
    public void visualise() {
//when visualise() is called, class variable line is 0

        this.val = 0;
//"traverseList" is called recursively with an argument of the whole list.
        traverseList(this.mySLList);
    }

//    Method has 3 sections: default action, condition goes to the end of the list, condition when it doesn't reach the end of the list
//    .. but each section does something different depending on which line of visualiser are we outputing
    private void traverseList(SLList existingList){
//        This is, let's call it, a section 1 - default action:

//      If val is equal to 0 for the first() value in the list then "[*|" will be printed
        if (this.val == 0){
            System.out.print("[*|");
        }
//      If val is equal to 1 then " |       " is printed to create space between values
        else if (this.val == 1){
            System.out.print(" |       ");
        }
//      If val is euqal to 2 then value of first() will be rpinted
        else if (this.val == 2 ){
//            this code is used for spacing
            int numSpaces = 9; // by default, there are  9 spaces between the 2 v. bars.
            int numberLength = existingList.first().toString().length(); //  but the number can have different length (like 1 and 100)
            numSpaces = numSpaces-numberLength; // so we change the number of spaces after the value to 9 minus whatever the length of the number is
            System.out.print(existingList.first().toString()); // then we output the value.
//           And then below we just print the rest of spaces to align to next v. bar
            // for (int i = 0; i < numSpaces; i++) {
            //     System.out.print(' ');
            // }
            int i = 0;
            while (i < numSpaces){
            	i++;
            	System.out.print(' ');
            }
        }

//         Case when we came to the end of the whole list.
        if (existingList.rest() == existingList.NIL) {
//            When it's line 0, display the "/]" bit and go to new line
            if (this.val != 0){
                // System.out.print("/] \n");
                System.out.print("\n");
            }
//            Otherwise, just go to a new line
            else {
                // System.out.print("\n");
                System.out.print("/] \n");
            }
//            Then we globally add 1 to our "line" class variable.
            this.val++;
//            and if only we aren't after line 3, do the whole recursive method again with the whole list (so that we draw next line of it)
            if (this.val < 3){
                traverseList(this.mySLList);
            }
        }
//        Case when we haven't reached the end of the whole list yet.
//        Method is called recursively with one "deeper" of our list, but if it's also line 0, then additionaly we display the "*] ->" bit.
        else {
            if (this.val == 0){
                System.out.print("*] -> ");
            }
            traverseList(existingList.rest());
        }
    }
}
