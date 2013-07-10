App =
  validateAndSubmitForm: (e) ->
    console.log("validating")
    debugger

    e.preventDefault()

  showSpinner: ->
    $(".spinner").show()

  hideSpinner: ->
    $('.spinner').hide()

$(->
  $('form').on("submit", App.validateAndSubmitForm)
)