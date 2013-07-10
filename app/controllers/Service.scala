package controllers


trait Service {
  def indexMessage : String
}

trait ServiceImpl {
  def indexMessage = {
    "Hello world"
  }
}