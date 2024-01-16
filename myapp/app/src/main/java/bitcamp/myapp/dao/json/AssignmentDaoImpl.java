package bitcamp.myapp.dao.json;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.vo.Assignment;
import java.util.List;

public class AssignmentDaoImpl extends AbstractDao<Assignment> implements AssignmentDao {

  private int lastKey;

  public AssignmentDaoImpl(String filepath) {
    super(filepath);
    lastKey = list.getLast().getNo();
  }

  public void add(Assignment assignment){
    assignment.setNo(++lastKey);
    this.list.add(assignment);
    saveData();
  }
  public int delete(int no){
    int index = indexOf(no);
    if (index == -1){
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;
  }
  public List<Assignment> findAll(){
    return list.subList(0,list.size());
  }

  public Assignment findBy(int no){
    int index = indexOf(no);
    if (index == -1){
      return null;
    }
    return list.get(index);
  }

  public int update(Assignment assignment){
    int index = indexOf(assignment.getNo());
    if (index == -1){
      return 0;
    }
    list.set(index, assignment);
    saveData();
    return 1;
  }

  public int indexOf(int no){
    for (int i = 0; i < list.size() ; i++){
      if(list.get(i).getNo() == no){
        return i;
      }
    }
    return -1;
  }
}

