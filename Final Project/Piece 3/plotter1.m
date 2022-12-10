

function createPlot()
  x = 0:100
  for i = 1:length(x)
    y = (9*(i) + 1/2)
  endfor

  subplot(2,2,1)
  plot(x,y,"b")
  title("Linear Graph=9x+1/2")
  hold on
  disp(x)
  disp(y)
  xlabel('x');
  ylabel('y');
  grid on
  set(gca, 'linewidth', 2.5, 'fontsize', 15)
  saltData(x,y)
endfunction

function saltData(x,y)
  counter = 1
  for i = 1:length(x)
    a = randi(15,1)
    b = randi(50,1)
    if(mod(counter,2) == 1)
    y(i) += (a-b)
  else
    y(i) -= (a+b)
  endif
  counter++
  endfor
    disp(y)
    subplot(2,2,2)
    plot(x,y,'b');
    title('Salted Linear Graph: y=9x+1/2')
    xlabel('x');
    ylabel('y');
    grid on
    set(gca, 'linewidth',2.5,'fontsize', 15)
    smoothData(x,y)
endfunction


function smoothData(x,y)
  s = []
  for i = 1.length(x)-2
    s = (y(i) + y(i+1) + y(i+2))/3
  endfor

  x(end) = [];
  y(end) = [];
  disp(s)
  subplot(2,2,3)
  plot(x,s,'b')
  title('Smoothed Linear Graph: y=9x+1/2')
  xlabel('x');
  ylabel('y');
  grid on
  set(gca,'linewidth',2.5,'fontsize',15)
endfunction

