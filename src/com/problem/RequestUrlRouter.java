package com.problem;

public class RequestUrlRouter  implements Router{

    Trie root;
    RequestUrlRouter(){
        root=new Trie();
    }
    @Override
    public String getCallBack() {
        return null;
    }

    @Override
    public void addUrlWithCallBack(UrlInfo urlInfo) {
         String url = urlInfo.getUrl();
         String urlArr[]=url.split("/");
         addPath(urlArr,urlInfo.result);
    }

    public void addPath(String urlPath[],String  result){
        Trie temp=root;
        for(int i=0;i<urlPath.length;i++){
            if(temp.dict.containsKey(urlPath[i])){
                temp=temp.dict.get(urlPath[i]);
            }else{
                temp.dict.put(urlPath[i],new Trie());
                temp=temp.dict.get(urlPath[i]);
            }

        }
        temp.isEnd = true;
        temp.value = result;
    }
    public String  getResult(String urlPath){
        String urlArr[] = urlPath.split("/");
        Trie temp=root;
        return traverse(urlArr,0,temp);
    }
    public String traverse(String urlArr[],int start,Trie temp){
        if(start==urlArr.length){
            return temp.value;
        }

            if(urlArr[start].equals("*")){
                for(String key:temp.dict.keySet()){
                   return traverse(urlArr,start+1,temp.dict.get(key));
                }
            }else {
                Trie t=temp.dict.get(urlArr[start]);
                String result=null;
                if(t!=null){
                    result= traverse(urlArr,start+1,t);
                }
                if(temp.dict.get("*")!=null&&result==null){
                    Trie ts=temp.dict.get("*");
                   return traverse(urlArr,start+1,ts);
                }
                return result;
            }
        return null;
    }
}
