package baek.others;

public class PGMS_new_id_recommend {

    public static void main(String[] args) throws Exception {
        System.out.println(solution("z-+.^."));
    }
    public static String solution(String new_id) {
        String reg1 = "[^\\w\\-\\.]*";

        new_id = new_id.toLowerCase().replaceAll(reg1, "");//1,2단계
        System.out.println("2단계 = "+new_id);
        while(new_id.contains("..")){//3단계
            new_id = new_id.replace("..", ".");
        }
        
        if(new_id.charAt(0)=='.'){//4단계-앞
            new_id = new_id.substring(1, new_id.length());
        }
        if(new_id.length()!=0 && new_id.charAt(new_id.length()-1)=='.'){//4단계-뒤
            new_id = new_id.substring(0, new_id.length()-1);
        }
        
        if(new_id.length()==0){//5단계
            new_id = "a";
        }

        if(new_id.length()>=16){//6단계
            if(new_id.charAt(14)=='.'){
                new_id = new_id.substring(0, 14);
            }else{
                new_id = new_id.substring(0, 15);
            }
        }

        if(new_id.length()<=2){//7단계
            if(new_id.length()==2){
                new_id = new_id+new_id.charAt(1);
            }else{
                new_id = new_id+new_id+new_id;
            }
        }

        return new_id;
    }
}