package bitcamp.myapp.dao.json;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.util.List;

public class MemberDaoImpl extends AbstractDao<Member> implements MemberDao {

  private int lastKey;

  public MemberDaoImpl(String filepath) {
    super(filepath);
    lastKey = list.getLast().getNo();
  }

  public void add(Member member){
    member.setNo(++lastKey);
    this.list.add(member);
    saveData();
  }

  public int delete(int no) {
    int index = indexOf(no);
    if (index == -1){
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;
  }

  public List<Member> findAll(){
    return this.list.subList(0,list.size());
  }

  public Member findBy(int no) {
    int index = indexOf(no);
    if (index == -1){
      return null;
    }
    return list.get(index);
  }

  public int update(Member member){
    int index = indexOf(member.getNo());
    if (index == -1){
      return 0;
    }
    list.set(index, member);
    saveData();
    return 1;
  }

  private int indexOf(int no) {
    for (int i =0; i< list.size(); i++){
      if (list.get(i).getNo() == no){
        return i;
      }
    }
    return -1;
  }

}