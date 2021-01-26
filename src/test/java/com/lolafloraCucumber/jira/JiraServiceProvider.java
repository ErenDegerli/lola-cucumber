package com.lolafloraCucumber.jira;

import net.rcarz.jiraclient.*;
import org.apache.log4j.Logger;
import java.io.File;

public class JiraServiceProvider{

    public Logger logger;
    public JiraClient jira;
    public String project;

    public JiraServiceProvider(String jiraUrl, String username, String password, String project){
        logger = Logger.getLogger(JiraServiceProvider.class);
        BasicCredentials credentials = new BasicCredentials(username, password);
        jira = new JiraClient(jiraUrl, credentials);
        this.project = project;
    }

    public void createJiraTicket(String issueType, String summary, String description, File file) throws JiraException {
            Issue newIssue = jira.createIssue(project, issueType)
            .field(Field.SUMMARY, summary)
            .field(Field.DESCRIPTION, description)
                    .execute();

            newIssue.addAttachment(file);
            logger.info("New Issue Created in Jira with ID: " + newIssue);
    }
}
