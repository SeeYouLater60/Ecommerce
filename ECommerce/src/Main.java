import java.util.ArrayList;

import Entitiys.concretes.Member;
import bussiness.abstracts.MemberService;
import bussiness.concretes.GoogleMemberManager;
import core.abstracts.ValidatorService;
import core.concretes.EmailCheckManager;
import core.concretes.NameCheckManager;
import core.concretes.PasswordCheckManager;
import core.concretes.RepeationCheckerManager;
import dataAccess.concretes.MemberDaoManager;
public class Main {

	public static void main(String[] args) {
		
		ValidatorService[] validatorServices = {new EmailCheckManager(),new NameCheckManager(),new PasswordCheckManager(),new RepeationCheckerManager(new ArrayList<String>())};
		
		
		MemberService memberService = new GoogleMemberManager(validatorServices,new MemberDaoManager(),new ArrayList<Member>());
		
		
		Member member = new Member("Tolga","Yaradanakul","zamzam123@outlook.com","1141545");
		memberService.register(member);
		
		Member member1 = new Member("Kadir","Has","eposta241@outlook.com","19194212");
		memberService.register(member1);
		
		
		Member member2 = new Member("Kaan","Prin�","eposta45432@outlook.com","199");
		memberService.register(member2);
		
		
		Member signIn = new Member("eposta123901@outlook.com","19956");
		memberService.login(signIn);
		
		
		System.out.println("All user that have registered :");
		for (Member user : memberService.getAllMembers()) {
			System.out.println("User name : "+user.getName()+" "+user.getLastName());
		}
		
		
	}

}
