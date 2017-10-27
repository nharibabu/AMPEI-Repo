package com.dxc.git.gitproject;

import java.io.File;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class JgitApp {

	public static void main(String[] args) {
		
		try{
			
		CredentialsProvider cp = new UsernamePasswordCredentialsProvider("nharibabu@csc.com", "cscHyd123");
		 File localPath = File.createTempFile("TestGitRepository", "");
		 if(!localPath.delete()) {
				System.out.println("Could not delete temporary file " + localPath);
	        }
		Git git = Git.init().setDirectory(localPath).call();
		localPath.delete();
			
			/*File localPath = File.createTempFile("TestGitRepository", "");
			if(!localPath.delete()) {
				System.out.println("Could not delete temporary file " + localPath);
	        }
			Repository repository = FileRepositoryBuilder.create(new File(localPath, ".git"));
			repository.create();
			System.out.println("Temporary repository at " + repository.getDirectory());
			File myfile = new File(repository.getDirectory().getParent(), "testfile");
            if(!myfile.createNewFile()) {
            	System.out.println("Could not create file " + myfile);
            }
            Git git = new Git(repository);
            git.add().addFilepattern("testfile").call();
            git.commit().setMessage("Added testfile").call();
            System.out.println("Added file " + myfile + " to repository at " + repository.getDirectory());*/
            
            String url = "https://github.com/nharibabu/AMPEI-Repo.git";
            File dir = new File("D:\\Architecture\\AMDN Proposal\\project");
            new CloneCommand()
                    .setCredentialsProvider(cp)
                    .setDirectory(dir)
                    .setURI(url)
                    .setCloneAllBranches(true).call();
                   
            
            System.out.println("Cloned repository into directory: "+dir);
            Git gitN = Git.open(dir);
            //CheckoutCommand command = new CheckoutCommand();
            gitN.checkout().setName("master").call();
            System.out.println("checkout called.");
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
