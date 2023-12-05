function rescue() {

command="$(bb "${RIP_DEADCODE_COMMAND_HOME}"/.command.clj | fzf)"

if [ -n "$command" ]; then
  command="$(sed -E "s/(^.* {8})//" <<< "$command")"

  eval "$command"
#  echo "$command"
fi

}
