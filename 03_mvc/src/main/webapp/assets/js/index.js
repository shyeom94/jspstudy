/**
 * 
 */
// servlet 을 개별로 만드는 것은 MVC 패턴이 아니다.
// 하나의 servlet 이 모든 요청을 받아서 해결한다. 
const getDateTime = ()=>{
  const type = document.getElementById('type');
  if(type.value === 'date'){
    location.href = '/mvc/getDate.do';
  } else if (type.value === 'time'){
    location.href = '/mvc/getTime.do';
  } else if (type.value === 'datetime'){
    location.href = '/mvc/getDateTime.do';
  }
}
// prefix <-> suffix  
document.getElementById('btn').addEventListener('click', getDateTime);
