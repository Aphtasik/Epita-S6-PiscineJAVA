package fr.epita.assistant.mytinyepita;

public class Assistant extends Person implements Observer<Student> {

    public Assistant(String login) {
        this.login = login;
    }

    @Override
    public void postNews(Newsgroup newsgroup, String message) {
        newsgroup.postNews(this, message);
    }

    @Override
    public void onEvent(Student event) {
        if (event.getStatus().equals(Status.ASKING_FOR_HELP))
        {
            System.out.println(this.login + " helps him.");
            event.setStatus(Status.OK);
        }
        else if (event.getStatus().equals(Status.TIRED))
        {
            System.out.println(this.login + " suggests " + event.getLogin() + " to go to sleep.");
        }
    }
}
