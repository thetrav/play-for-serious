package controllers

import play.api._
import play.api.mvc._

object Application extends ApplicationController
                   with ServiceImpl  {
  def template = views.html.index.apply
}

trait ApplicationController extends Controller
                            with Service {
  def template: (String) => play.api.templates.Html

  def index = Action {
    Ok(template("controller got:" + indexMessage))
  }
}