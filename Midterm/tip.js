function tipCalculate (slider, bill){
  var tip = document.getElementById('tipamount');
  var slideval = document.getElementById('slideval');
  var bill = document.getElementById(bill).value;
  var prcnt = slider * .01;
  
  
  if (bill == null || bill == '') {
    tip.innerHTML = 'Please enter an amount';
    return false;
  }
  if(isNaN(bill)) {
    tip.innerHTML = 'Please enter a number';
    return false;
  }
  if(bill >= 0){
    tip.innerHTML = '$' + (bill * prcnt) .toFixed(2);
  slideval.innerHTML = slider + '%';
  }
}