public class Task {
    private  String tgtText;
    public  Task(String tgt_text){
        tgtText = tgt_text;
    }

    public int getResultText(){
        String resultText = "";
        if(tgtText.equals("")){
            //resultText = "未入力です";
            return -1;
        }else if (!isNumber(tgtText)){
            //resultText = "数値ではありません";
            return -1;
        }else {
            int tgtInt = Integer.parseInt(tgtText);
            if(tgtInt < 0){
                //resultText = "範囲外です";
                return -1;
            }else {
                return tgtInt;
            }
        }
    }

    public boolean isNumber(String val){
        try {
            Integer.parseInt(val);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}
