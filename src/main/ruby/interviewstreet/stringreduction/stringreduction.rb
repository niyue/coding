def reduction_count(string)
  if(string.length == 1)
    return 1
  end
  
  a_count = 0
  b_count = 0
  c_count = 0
  
  for c in string
    if(c.eql?('a'))
      a_count += 1
    elsif(c.eql?('b'))
      b_count += 1
    else
      c_count += 1
    end
  end
  
  if(a_count == 0 && b_count == 0 || b_count == 0 && c_count == 0 || c_count == 0 && a_count ==0)
    return string.length
  end
  
  a_odd = a_count % 2 != 0
  b_odd = b_count % 2 != 0
  c_odd = c_count % 2 != 0
  
  if(a_odd && b_odd && c_odd || !a_odd && !b_odd && !c_odd)
    return 2
  end
  return 1
end

t = gets.chomp.to_i
strings = []
for i in 1..t
  strings << gets.chomp.chars.to_a
end

count_table = {}
for string in strings
  puts reduction_count(string)
end