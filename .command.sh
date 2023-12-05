function rescue() {

command="$(bb .command.clj | fzf)"

if [ -n "$command" ]; then
  command="$(sed -E "s/(^.* {8})//" <<< "$command")"

  eval "$command"
#  echo "$command"
fi

}
