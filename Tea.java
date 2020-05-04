public class Tea {

    private double[] probs = {0.5, 0.25, 0.15, 0.07, 0.03};
    //fields
    private String myName;
    private int myType; //scale 0 to 4
    private int myQuantity;

    //constructers (idk how to spell)
    public Tea(String name, int quantity, int type){
       /// haha who needs error checking ; ;
        myName = name;
        myQuantity = quantity;
        myType = type;
    }
    //functions
    //getName
    public String getName(){
        return myName;
    }
    //getType
    public double getProb() {
        return probs[myType];
    }
    //getQuantity
    public int getQuantity(){
        return myQuantity;
    }
    public void drink(){
        myQuantity--;

    }
    public boolean isEmpty(){
        if(myQuantity==0){
            return true;
        }else{
            return false;
        }
    }
    public void setEmpty() {
        myQuantity = 0;
    }
    public void setQuantity(int newQuantity) {
        myQuantity = newQuantity;
    }
    public void changeType(int newType){
        myType = newType;
    }
    public String fileString(){
        //System.out.println( myName+ "-" + myQuantity + "-" + myType);
        return myName+ "-" + myQuantity + "-" + myType;
    }
    public String toString(){
      //  System.out.println("check");
        return "Name: "+myName+"\n Quantity: " + myQuantity+ "\n Type: "+ myType + "\n Probability: "+ probs[myType];
    }

}
