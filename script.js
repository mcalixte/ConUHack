var data;
function updateValues(dat)
{
  if (data[0].message.length > 0) {
    document.getElementById('red-1').style.visibility = "visible";
    document.getElementById('red-1').innerHTML = dat[0].message.length;
  }
  else
  {
    document.getElementById('red-1').style.visibility = "hidden";
    document.getElementById('red-1').innerHTML = dat[0].message.length;
  }
  if (data[1].message.length > 0) {
      document.getElementById('red-2').style.visibility = "visible";
      document.getElementById('red-2').innerHTML = dat[1].message.length;
    }
  else
  {
    document.getElementById('red-2').style.visibility = "hidden";
    document.getElementById('red-2').innerHTML = dat[0].message.length;
  }
  
}


 function fun1()
{
  alert(data[0].message[0]);
  $.get("delete");
}

setInterval(function()
{
  $.get("elders" , function(dat)
  {
    data = dat;
    updateValues(dat);
  });
}
, 1000)
