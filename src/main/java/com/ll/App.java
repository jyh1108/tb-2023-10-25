package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    int lastQuotationId;
    List<Quotation> quotations;
    Scanner scanner;

    App(){
        scanner  = new Scanner(System.in);
        lastQuotationId = 1;
        quotations = new ArrayList<>();
    }
    void run() {
        System.out.println("=== 명령 앱 ===");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();

            } else if (cmd.equals("목록")) {
                actionList();
            }
        }
    }
    private void actionList() {
        System.out.println("총 개수 : " + quotations.size());
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------------");
        if (quotations.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
        }
        for (int i = quotations.size() - 1; i >= 0; i--) {
            System.out.println(quotations.get(i).id + "/" + quotations.get(i).authorName + "/" + quotations.get(i).content);
        }
    }

    private void actionWrite() {
        System.out.print("명언 :");
        String content = scanner.nextLine();
        System.out.print("작가 :");
        String authorName = scanner.nextLine();
        int id = lastQuotationId;
        Quotation quotation = new Quotation(id, content, authorName);
        quotations.add(quotation);
        System.out.println(lastQuotationId + "번 명언이 등록되었습니다.");
        lastQuotationId += 1;
    }
}
