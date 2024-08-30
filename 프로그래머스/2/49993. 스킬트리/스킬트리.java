class Solution {
    public int solution(String skill, String[] skill_Trees) {
        int answer = 0;
        for(String skill_Tree : skill_Trees){
            char[] skillTree = skill_Tree.toCharArray();
            int index = 0;
            boolean isAnswer = true;
            int prev = 0;
            for(int i=0;i<skill.length();i++)
            {
                boolean isValid = false;
                for(int j = prev;j<skillTree.length;j++)
                {
                    if(skill.charAt(i)==skillTree[j]){
                        prev = j+1;
                        skillTree[j] = '0';
                        isValid = true;
                        break;
                    }
                }
                if(!isValid){
                    break;
                }
            }
            // for(int i=0;i<skillTree.length;i++)
            // {
            //     System.out.print(skillTree[i]);
            // }
            // System.out.println();
            for(int i=0;i<skill.length();i++)           
            {
                char c = skill.charAt(i);
                for(int j=0;j<skillTree.length;j++)
                {
                    if(skillTree[j]==c){
                        isAnswer= false;
                    }
                }                
            }
            if(isAnswer){
                // System.out.println(skill_Tree);
                answer++;
            }
        }
        return answer;
    }
}