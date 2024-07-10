package com.dbc.model;

import com.dbc.repository.BattleRepository;
import com.dbc.service.BattleService;
import com.dbc.service.MenuService;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    private Integer idBattle;
    private Integer winnerId;
    private Integer loserId;
    private CharacterFight player1;
    private CharacterFight player2;
    private final MusicPlayer MUSICPLAYER = new MusicPlayer();
    private MenuService menuService = new MenuService();


    public Battle(CharacterFight player1, CharacterFight player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Battle(Integer winnerId, Integer loserId) {
        this.winnerId = winnerId;
        this.loserId = loserId;
    }

    public Battle() {
    }

    public Integer getWinnerId() {
        return winnerId;
    }
    public Integer getLoserId() {
        return loserId;
    }

    public void setWinnerId(Integer winnerId) {
        this.winnerId = winnerId;
    }

    public Integer getIdBattle() {
        return idBattle;
    }

    public Integer getIdPlayer1() {
        return player1.getId();
    }
    public Integer getIdPlayer2() {
        return player2.getId();
    }

    public void setIdBattle(Integer idBattle) {
        this.idBattle = idBattle;
    }

    public CharacterFight getPlayer1() {
        return player1;
    }

    public CharacterFight getPlayer2() {
        return player1;
    }


    public void battle() throws InterruptedException {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playerBattleMusic();
        Scanner scanner = new Scanner(System.in);

        System.out.println(player1.getId()+"======================================================");
        while (player1.getHitPoints() > 0 && player2.getHitPoints() > 0) {

            menuService.battleScreen(player1, player2);
            int opt = 0;
            try {
                opt = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException exception){
                System.out.println("Entrada incorreta! Perdeu o turno, o inimgo não espera!\n");
                scanner.nextLine();
                Thread.sleep(2000);
            }

            int damage = 0;
            switch (opt) {
                case 1:
                    damage = player1.lightAttack(player1.getStrenght());
                    battleCheckerP1(damage);
                    break;
                case 2:
                    damage = player1.heavyAttack(player1.getStrenght());
                    battleCheckerP1(damage);
                    break;
                case 3:
                    damage = player1.specialAttack(player1.getStrenght());
                    battleCheckerP1(damage);
                    break;
                case 4:
                    musicPlayer.stopMusic();
                    System.out.printf("%s fugiu com sucesso!", player1.getName());
                    musicPlayer.playerEscapeMusic();
                    Thread.sleep (1000);
                    musicPlayer.stopMusic();
                    return;
            }

            Random random = new Random();
            opt = random.nextInt(3)+1;
            switch (opt) {
                case 1:
                    damage = player2.lightAttack(player2.getStrenght());
                    battleCheckerP2(damage);
                    break;
                case 2:
                    damage = player2.heavyAttack(player2.getStrenght());
                    battleCheckerP2(damage);
                    break;
                case 3:
                    damage = player2.specialAttack(player2.getStrenght());
                    battleCheckerP2(damage);
                    break;
            }

        }
        musicPlayer.stopMusic();

        System.out.println("-----------------------------------------------------------------------");
        if (player1.getHitPoints() <= 0) {
            System.out.println("*************** " + player2.getName() + " venceu o combate!"+ " ***************");
            musicPlayer.playerGameOverMusic();
            Thread.sleep (6000);
            System.out.println("-----------------------------------------------------------------------");
//            score.addPlauer(player2.getName());
        } else {

            System.out.println("*************** " + player1.getName() + " venceu o combate!" + " ***************");
            musicPlayer.playerWinMusic();
            Thread.sleep (8000);
            System.out.println("-----------------------------------------------------------------------");
//            score.addPlauer(player1.getName());
        }
         winnerId = player1.getHitPoints() <= 0 ? player2.getId() : player1.getId();
         loserId = player1.getHitPoints() <= 0 ? player1.getId() : player2.getId();

         //pegar id player

        new BattleService(new BattleRepository()).insert(new Battle(winnerId, loserId));
        musicPlayer.stopMusic();

        resetStats(player1);
        resetStats(player2);
    }

    public void resetStats(CharacterFight player) {
        player.setHitPoints(10);
    }

    public void battleCheckerP1(int damage) throws InterruptedException {
        System.out.println("Turno de "+player1.getName());
        if (player2.deduceHitPoints(damage)){
            System.out.println(player1.getName() + " causou " + damage + " de dano a " + player2.getName());
            System.out.println(player2.getName() + " agora tem " + player2.getHitPoints() + " pontos de vida.\n");
            MUSICPLAYER.playerAttackMusic();
            menuService.impactFrameHit();
            Thread.sleep(1500);
        } else {
            System.out.println(player1.getName() + " errou!," + player2.getName() + " ainda tem " + player2.getHitPoints() + " pontos de vida");
            MUSICPLAYER.playerDodgeMusic();
            menuService.impactFrameDodge();
            Thread.sleep(1500);
        }
    }

    public void battleCheckerP2(int damage) throws InterruptedException {
        System.out.println("Turno de "+player2.getName());
        if (player1.deduceHitPoints(damage)){
            System.out.println(player2.getName() + " causou " + damage + " de dano a " + player1.getName());
            System.out.println(player1.getName() + " agora tem " + player1.getHitPoints() + " pontos de vida.\n");
            MUSICPLAYER.playerAttackMusic();
            menuService.impactFrameHit();
            Thread.sleep(1500);
        } else {
            MUSICPLAYER.playerDodgeMusic();
            System.out.println(player2.getName() + " errou!," + player1.getName() + " ainda tem " + player1.getHitPoints() + " pontos de vida");
            menuService.impactFrameDodge();
            Thread.sleep(1500);
        }
    }
}
