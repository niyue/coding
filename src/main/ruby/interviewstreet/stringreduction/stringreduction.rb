def reduction_count(string, count_table)
  if(string.length == 1)
    return 1
  elsif(string.length == 2)
    return is_reducible(string, 0) ? 1 : 2
  end
  count = string.length
  for i in 0..(string.length-2)
    if is_reducible(string, i)
      reduced_string = reduce(string, i)
      #if count_table[reduced_string].nil?
        reduced_count = reduction_count(reduced_string, count_table)
      #else
      #  reduced_count = count_table[reduced_string]
      #end
      if reduced_count < count
        count = reduced_count
      end
    end
  end  
  #count_table[string] = count
  return count
end

def reduce(string, index)
  one = string[index].bytes.next - ?a.ord
  two = string[index+1].bytes.next - ?a.ord
  sum = one + two
  new_char = 'a'
  if sum == 1 # a,b
    new_char = 'c'
  elsif sum == 2
    new_char = 'b'
  end
  reduced_string = Array.new(string)  
  reduced_string.delete_at(index)
  reduced_string[index] = new_char
  return reduced_string
end

def is_reducible(string, index)
  return string[index] != string[index+1]
end

t = gets.chomp.to_i
strings = []
for i in 1..t
  strings << gets.chomp.chars.to_a
end

count_table = {}
for string in strings
  puts reduction_count(string, count_table)
end
