%% Ping Pong
%%
%% Isadora Salvetti
%% 
%% Goktug Cengiz
%%
%% Mehmet Fatih Cagil
%%

-module(pingpong).
-export([start/0, ping/2, pong/0]).

start() ->
    Pong_PID = spawn(pingpong, pong, []),
    spawn(pingpong, ping, [3, Pong_PID]).


ping(0, Pong_PID) ->
    Pong_PID ! finished,
    io:format("Ping finished~n", []);


ping(N, Pong_PID) ->
    Pong_PID ! {ping, self()},
    receive
        pong ->
            io:format("Ping received pong~n", [])
    end,
    ping(N - 1, Pong_PID).


pong() ->
    receive
        finished ->
            io:format("Pong finished~n", []);
        {ping, Ping_PID} ->
            io:format("Pong received ping~n", []),
            Ping_PID ! pong,
            pong()
    end.

