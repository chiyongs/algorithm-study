import practice.순열구하기8_6;
import practice.조합구하기8_9;
import programmers.bfsdfs.PGS_BFSDFS_여행경로;
import programmers.디스크컨트롤러;
import programmers.카카오.블라인드채용2022.k진수에서소수개수구하기.k진수에서소수개수구하기;
import programmers.카카오.블라인트채용2023.택배배달과수거하기.택배배달과수거하기;

public enum 오답노트 {

    택배배달과수거하기(택배배달과수거하기.class,"https://school.programmers.co.kr/learn/courses/30/lessons/150369?language=java"),
    k진수에서소수개수구하기(k진수에서소수개수구하기.class, "https://school.programmers.co.kr/learn/courses/30/lessons/92335?itm_content=course14743"),
    여행경로(PGS_BFSDFS_여행경로.class, "https://school.programmers.co.kr/learn/courses/30/lessons/43164?itm_content=course14743#"),
    디스크컨트롤러(디스크컨트롤러.class, "https://school.programmers.co.kr/learn/courses/30/lessons/42627?itm_content=course14743#"),
    조합구하기(조합구하기8_9.class, ""),
    순열구하기(순열구하기8_6.class, "")
    ;

    Class solution;
    String link;

    오답노트(Class solution, String link) {
        this.solution = solution;
        this.link = link;
    }
}
